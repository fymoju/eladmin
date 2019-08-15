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
@Table(name="dictionary_middle")
public class Middle {


	@Id
	@NotNull
	private Integer middle_id;//



	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;//

	private String name;//




	
}
