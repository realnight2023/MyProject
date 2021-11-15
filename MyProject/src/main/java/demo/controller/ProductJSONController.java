package demo.controller;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;
import com.google.gson.JsonArray;

import model.*;
import java.util.*;
@Controller
@RequestMapping(value = "/json")
public class ProductJSONController {
	@RequestMapping(value = "home", method = RequestMethod.GET)
	public String index() {
		return "json/home";
	}
	@RequestMapping(value = "pts", method = RequestMethod.POST, consumes=MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public List<Product> products(@RequestBody JsonArray jsonParam) {
	    List<Product> list = new Gson().fromJson(jsonParam, ArrayList.class);
	    return list;
	}
}