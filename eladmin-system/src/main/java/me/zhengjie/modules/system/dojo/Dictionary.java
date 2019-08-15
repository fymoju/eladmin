package me.zhengjie.modules.system.dojo;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

/**
 * 实体类
 * @author Administrator
 *
 */
@Entity
@Data
@Table(name="dictionary")
public class Dictionary {


	@NotNull
	private String key;//

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;//

	private String name;//




	
}
