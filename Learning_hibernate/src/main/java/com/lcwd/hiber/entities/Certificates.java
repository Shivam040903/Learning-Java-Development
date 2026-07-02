package com.lcwd.hiber.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "student_certificate")
public class Certificates {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long certificateId;
	
	public long getCertificateId() {
		return certificateId;
	}

	public void setCertificateId(long certificateId) {
		this.certificateId = certificateId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getLink() {
		return link;
	}

	public void setLink(String link) {
		this.link = link;
	}

	public String getAbout() {
		return about;
	}

	public void setAbout(String about) {
		this.about = about;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	private String title;
	private String link;
	private String about;
	
	@ManyToOne
	@JoinColumn(name = "student_id")
	private Student student;
}
