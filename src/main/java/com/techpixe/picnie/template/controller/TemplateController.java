package com.techpixe.picnie.template.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.techpixe.picnie.template.entity.Template;
import com.techpixe.picnie.template.repository.TemplateRepository;
import com.techpixe.picnie.template.service.TemplateService;

@RestController
@RequestMapping("/templates")
public class TemplateController {

	@Autowired
	private TemplateService templateService;

	@PostMapping
	public Template createTemplate(@RequestBody Template template) {
		return templateService.save(template);
	}

	@GetMapping("/transform")
	public String transformText(@RequestParam String text, @RequestParam int size) {
		return templateService.transformText(text, size);
	}

	// Endpoint to fetch all templates
	@GetMapping
	public List<Template> getAllTemplates() {
		return templateService.findAll();
	}

	@PostMapping("/edit-text")
	public String editText(@RequestBody Template attributes) {
		return templateService.editText(attributes);
	}

	@GetMapping("/edit-text")
	public String editText(@RequestParam String text, @RequestParam String font,@RequestParam int size,@RequestParam String textColor, @RequestParam double angle,
			@RequestParam double destX, @RequestParam double destY, @RequestParam double maxLength,
			@RequestParam int maxLines, @RequestParam int letterSpacing, @RequestParam double lineHeight,
			@RequestParam String textAlign) {
		Template attributes = new Template();
		attributes.setText(text);
		attributes.setFontStyle(font);
		attributes.setTextSize(size);
		attributes.setTextColor(textColor);
		attributes.setAngle(angle);
		attributes.setDestX(destX);
		attributes.setDestY(destY);
		attributes.setMaxLength(maxLength);
		attributes.setMaxLines(maxLines);
		attributes.setLetterSpacing(letterSpacing);
		attributes.setLineHeight(lineHeight);
		attributes.setTextAlign(textAlign);

		return templateService.editText(attributes);
	}

}
