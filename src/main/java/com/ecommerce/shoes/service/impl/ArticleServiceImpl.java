package com.ecommerce.shoes.service.impl;

import java.util.Base64;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.ecommerce.shoes.model.Article;
import com.ecommerce.shoes.repository.ArticleRepository;
import com.ecommerce.shoes.repository.ArticleSpecification;
import com.ecommerce.shoes.service.ArticleService;
import com.ecommerce.shoes.utils.ImageUpload;



@Service
@Transactional
public class ArticleServiceImpl implements ArticleService {

	@Autowired
	private ArticleRepository articleRepository;
	@Autowired
	private ImageUpload imageUpload;
	
	@Value("${articleservice.featured-items-number}")
	private int featuredArticlesNumber;

	@Override
	public List<Article> findAllArticles() {
		return (List<Article>) articleRepository.findAllEagerBy();
	}

	@Override
	public Page<Article> findArticlesByCriteria(Pageable pageable, Integer priceLow, Integer priceHigh,
			List<String> sizes, List<String> categories, List<String> brands, String search) {
		Page<Article> page = articleRepository.findAll(
				ArticleSpecification.filterBy(priceLow, priceHigh, sizes, categories, brands, search), pageable);
		return page;
	}

	@Override
	public List<Article> findFirstArticles() {
		return articleRepository.findAll(PageRequest.of(0, featuredArticlesNumber)).getContent();
	}

	@Override
	public Article findArticleById(Long id) {
		Optional<Article> opt = articleRepository.findById(id);
		return opt.get();
	}

	/**
	 * draft
	 */
	@Override
	@CacheEvict(value = { "sizes", "categories", "brands" }, allEntries = true)

	public Article save(MultipartFile imageProduct, Article article) {
		try {
			Article	 article1= new Article();
			if (imageProduct == null) {
				article.setPicture(null);
			} else {
				if (imageUpload.uploadImage(imageProduct)) {
					System.out.println("Upload successfully");
				}
				article.setPicture(Base64.getEncoder().encodeToString(imageProduct.getBytes()));
			}
			/**
			 * this is attributes of ArticleDTO:
			 * 
			 * private Long id;
			 * 
			 * private String title;
			 * 
			 * private double price;
			 * 
			 * private String picture;
			 */
			

			  article1.setTitle(article.getTitle());
			  article1.setPrice(article.getPrice());
			 
			return articleRepository.save(article);
			/*
			 * product.setName(productDto.getName());
			 * product.setDescription(productDto.getDescription());
			 * product.setCategory(productDto.getCategory());
			 * product.setCostPrice(productDto.getCostPrice());
			 * product.setCurrentQuantity(productDto.getCurrentQuantity());
			 * product.setIs_activated(true); product.setIs_deleted(false);
			 * 
			 * return productRepository.save(product);
			 */
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	//
	@Override
	@CacheEvict(value = { "sizes", "categories", "brands" }, allEntries = true)
	public Article saveArticle(Article article) {
		return articleRepository.save(article);
	}

	@Override
	@CacheEvict(value = { "sizes", "categories", "brands" }, allEntries = true)
	public void deleteArticleById(Long id) {
		articleRepository.deleteById(id);
	}

	@Override
	@Cacheable("sizes")
	public List<String> getAllSizes() {
		return articleRepository.findAllSizes();
	}

	@Override
	@Cacheable("categories")
	public List<String> getAllCategories() {
		return articleRepository.findAllCategories();
	}

	@Override
	@Cacheable("brands")
	public List<String> getAllBrands() {
		return articleRepository.findAllBrands();
	}

}
