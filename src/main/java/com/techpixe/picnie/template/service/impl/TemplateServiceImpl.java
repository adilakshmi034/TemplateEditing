package com.techpixe.picnie.template.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.techpixe.picnie.template.entity.Template;
import com.techpixe.picnie.template.repository.TemplateRepository;
import com.techpixe.picnie.template.service.TemplateService;

@Service
public class TemplateServiceImpl implements TemplateService {

	@Autowired
	TemplateRepository templateRepository;

	@Override
	public Template save(Template template) {
		return templateRepository.save(template);
	}

	@Override
	public List<Template> findAll() {
		return templateRepository.findAll();
	}

	public String transformText(String text, int size) {
		return "<span style=\"font-size: " + size + "px;\">" + text + "</span>";
	}

	public String editText(Template textAttributes) {
		// Build the HTML or JSON representation based on the text attributes
		StringBuilder htmlBuilder = new StringBuilder();
		htmlBuilder.append("<div style=\"");
		htmlBuilder.append("font-style: ").append(textAttributes.getFontStyle()).append("; ");       
	    htmlBuilder.append("font-size: ").append(textAttributes.getTextSize()).append("px; ");
		htmlBuilder.append("color: rgb(").append(textAttributes.getTextColor()).append(");");
		htmlBuilder.append("transform: rotate(").append(textAttributes.getAngle()).append("deg);");
		htmlBuilder.append("position: absolute; left: ").append(textAttributes.getDestX()).append("%; top: ")
				.append(textAttributes.getDestY()).append("%;");
		htmlBuilder.append("max-width: ").append(textAttributes.getMaxLength()).append("%;");
		htmlBuilder.append("line-height: ").append(textAttributes.getLineHeight()).append(";");
		htmlBuilder.append("letter-spacing: ").append(textAttributes.getLetterSpacing()).append("px;");
		htmlBuilder.append("text-align: ").append(textAttributes.getTextAlign()).append(";\">");
		htmlBuilder.append(textAttributes.getText());
		htmlBuilder.append("</div>");

		return htmlBuilder.toString();
	}

}
