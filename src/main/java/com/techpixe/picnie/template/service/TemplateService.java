package com.techpixe.picnie.template.service;

import java.util.List;

import com.techpixe.picnie.template.entity.Template;

public interface TemplateService {

	Template save(Template template);

	List<Template> findAll();

	String transformText(String text, int size);

	String editText(Template attributes);

}
