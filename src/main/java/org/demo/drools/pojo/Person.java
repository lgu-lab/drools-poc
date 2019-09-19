package org.demo.drools.pojo;

public class Person {

	private final String name;
	private int age;
	private final String topic;

	public Person(String name, int age, String topic) {
		this.name = name;
		this.age = age;
		this.topic = topic;
	}

	public String getName() {
		return name;
	}

	public int getAge() {
		return age;
	}

	public String getTopic() {
		return topic;
	}

	public String introduceYourself() {
		return "Hello, I'm " + name;
	}

	@Override
	public String toString() {
		return "Person [name=" + name + ", age=" + age + ", topic=" + topic + "]";
	}

	@Override
	public int hashCode() {
		Counters.hashCode++ ;
		final int prime = 31;
		int result = 1;
		result = prime * result + age;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((topic == null) ? 0 : topic.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		Counters.equals++ ;
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Person other = (Person) obj;
		if (age != other.age)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (topic == null) {
			if (other.topic != null)
				return false;
		} else if (!topic.equals(other.topic))
			return false;
		return true;
	}
	
	
}
 