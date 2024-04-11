package com.techpixe.picnie.template.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Template {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String text;
	private String fontStyle;
	private int textSize;
	private String textColor;
	private double angle;
	private double destX;
	private double destY;
	private double maxLength;
	private int maxLines;
	private int letterSpacing;
	private double lineHeight;
	private String textAlign;

}
