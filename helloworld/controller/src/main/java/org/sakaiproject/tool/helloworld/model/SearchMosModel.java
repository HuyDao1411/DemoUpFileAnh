package org.sakaiproject.tool.helloworld.model;
import java.io.Serializable;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import lombok.Getter;
import lombok.Setter;
@Getter @Setter
public class SearchMosModel implements Serializable {
	private MultipartFile attachment;

} 	
