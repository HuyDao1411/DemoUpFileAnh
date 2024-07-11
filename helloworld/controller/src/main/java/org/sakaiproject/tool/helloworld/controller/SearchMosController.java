//package org.sakaiproject.tool.helloworld.controller;
//
//import java.io.IOException;
//import java.util.ArrayList;
//import java.util.List;
//
//import org.sakaiproject.tool.helloworld.model.SearchMosModel;
//import org.springframework.stereotype.Controller;
//import org.springframework.util.Base64Utils;
//import org.springframework.validation.BindingResult;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.ModelAttribute;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.multipart.MultipartFile;
//import org.springframework.web.servlet.ModelAndView;
//
//@Controller
//public class SearchMosController extends BaseController {
//
//    @GetMapping(value = "/")
//    public ModelAndView uploadImageRefresh() {
//        ModelAndView mav = new ModelAndView("search-result");
//        mav.addObject("model", new SearchMosModel());
//        return mav;
//    }
//
//    @PostMapping(value = "/searchmos/upload")
//    public ModelAndView uploadImage(@ModelAttribute("model") SearchMosModel model, BindingResult bindingResult) throws IOException {
//        ModelAndView mav = new ModelAndView("search-result");
//
//        MultipartFile file = model.getAttachment();
//        String base64Image = Base64Utils.encodeToString(file.getBytes());
//
//        // Initialize list if null
//        if (model.getImages() == null) {
//            model.setImages(new ArrayList<>());
//        }
//
//        // Add base64 encoded image to list
//        model.getImages().add(base64Image);
//
//        mav.addObject("images", model.getImages());
//        return mav;
//    }
//}
package org.sakaiproject.tool.helloworld.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.sakaiproject.tool.helloworld.model.SearchMosModel;
import org.springframework.stereotype.Controller;
import org.springframework.util.Base64Utils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class SearchMosController extends BaseController {
	
	private List<Object[]> filee= new ArrayList<>(); 
    private List<String> base64s = new ArrayList<>(); 
    private List<String> fileTypes = new ArrayList<>(); 

    @GetMapping(value = "/")
    public ModelAndView uploadImageRefresh() {
        ModelAndView mav = new ModelAndView("search-result");
        mav.addObject("model", new SearchMosModel());
        mav.addObject("base64s", base64s); // Pass the list of images to the view
        return mav;
    }

    @PostMapping(value = "/searchmos/upload")
    public ModelAndView uploadImage(@ModelAttribute("model") SearchMosModel model, BindingResult bindingResult) throws IOException {
        ModelAndView mav = new ModelAndView("search-result");

        MultipartFile file = model.getAttachment();
        String fileType= file.getContentType();
        String base64Image = Base64Utils.encodeToString(file.getBytes());
        // Add base64 encoded image to the list
        base64s.add(base64Image);
        fileTypes.add(fileType);
        filee.add(new Object[] {base64Image,fileType});
        mav.addObject("base64s", base64s);
        mav.addObject("fileTypes", fileTypes);
        mav.addObject("filee",filee);
        return mav;
    }
}