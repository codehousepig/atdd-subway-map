package subway.line;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import subway.section.Section;
import subway.section.Sections;

@Entity
public class Line {

	@Id
	@Column(name = "line_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(length = 20, nullable = false)
	private String name;

	@Column(length = 30, nullable = false)
	private String color;

	@Embedded
	private Sections sections;

	public Line() {
	}

	public Line(String name, String color) {
		this.name = name;
		this.color = color;
		this.sections = new Sections();
	}

	public void updateLine(String name, String color) {
		this.name = name;
		this.color = color;
	}

	public Section addSection(Section section) {
		return this.sections.addSection(section);
	}

	public Long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getColor() {
		return color;
	}

	public Sections getSections() {
		return sections;
	}
}
