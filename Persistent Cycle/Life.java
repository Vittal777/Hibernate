package com.sql.life;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
/**
 * Hello world!
 *
 */
@Entity
public class Life 
{
    private int age;
    private String prob;
    @Id
    private String name;
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getProb() {
		return prob;
	}
	public void setProb(String prob) {
		this.prob = prob;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
}
