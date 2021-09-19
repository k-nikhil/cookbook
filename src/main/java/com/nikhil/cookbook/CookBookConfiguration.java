package com.nikhil.cookbook;

import org.dozer.DozerBeanMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jdk8.Jdk8Module;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.fasterxml.jackson.module.paramnames.ParameterNamesModule;



@Configuration
public class CookBookConfiguration {

//	@Bean
//	public Mapper mapper(@Value(value = "classpath*:mappings/*mappings.xml") Resource[] resourceArray) throws IOException {
//	    List<String> mappingFileUrlList = new ArrayList<>();
//	    for (Resource resource : resourceArray) {
//	        mappingFileUrlList.add(String.valueOf(resource.getURL()));
//	    }
//	    DozerBeanMapper dozerBeanMapper = new DozerBeanMapper();
//	    dozerBeanMapper.setMappingFiles(mappingFileUrlList);
//	    return dozerBeanMapper;
//	}

	@Bean
	public ObjectMapper objectMapper() {
		ObjectMapper mapper = new ObjectMapper();
		mapper.registerModule(new ParameterNamesModule())
		   .registerModule(new Jdk8Module())
		   .registerModule(new JavaTimeModule());
		mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		mapper.configure(MapperFeature.DEFAULT_VIEW_INCLUSION, true);
		mapper.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);
		return mapper;
	}
	
	@Bean
	public DozerBeanMapper dozerBeanMapper() {
		return new DozerBeanMapper();
	}
}
