package com.usyd.elec5619.domain;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.xml.bind.annotation.XmlRootElement;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.springframework.web.multipart.MultipartFile;

@Entity
@Table (name ="user")

public class Users {
	 
	 @Id
     @GeneratedValue
	 private Long id;
	 
	 @Column(name="username",unique=true)
	  private String username;
	 
	 @Column(name="password",length = 60)
	  private String password;
	 
	 @Column(name="name")
	  private String name;
	 
	 @Column(name="email",length = 100)
	  private String email;  
	 
	  @Column(name="update_by_email")
	  private boolean updateByEmail;
	  
	  @Column(name = "faculty")
	  private String faculty;
	  
	  @Column(name = "major")
	  private String major;
	  
	  @Column(name = "degree")
	  private String degree;
	  
	  @Column(name = "gender")
	  private String gender; 
	  
	  @Column(name = "year")
	  private String year;
	  
	  @Column(name = "nationality")
	  private String nationality;
	  
	  @Column(name = "imageName")
	  private String imageName;
	  
	  @Column(name = "imagePath")
	  private String path;
	  
	  @Column(name = "isAdmin")
	  private int isAdmin;
	  
	  @Transient
	  private MultipartFile userImage;
	  
	  /*//@ElementCollection
      @CollectionTable(name="followers")
      private  ArrayList<String> followers = new ArrayList<String>();;*/
	  
	   
	  @OneToMany(mappedBy = "user")
	  private Set<Posts> posts = new HashSet<Posts>();
	  
	  @ManyToMany(cascade = {CascadeType.ALL},fetch = FetchType.EAGER)
	  @JoinTable(name = "user_friends",
      	joinColumns = @JoinColumn(name = "user_id", referencedColumnName = "id"),
      	inverseJoinColumns = @JoinColumn(name = "friends_id", referencedColumnName = "id"))
	  @OrderBy("name ASC")
	  @Fetch (FetchMode.SELECT)
	  
	  private Collection<Users> friends = new ArrayList<>();
	  
	  public Long getId() {
	    return id;
	  }

	  public void setId(Long id) {
	    this.id = id;
	  }
	  
	  public String getUsername() {
	    return this.username;
	  }

	  public void setUsername(String username) {
	    this.username = username;
	  }
	  
	  public String getPassword() {
	    return this.password;
	  }

	  public void setPassword(String password) {
	    this.password = password;
	  }

	  public void setName(String name) {
	    this.name = name;
	  }
	  
	  public String getName() {
	    return name;
	  }
	  
	  public void setEmail(String email) {
	      this.email = email;
	  }
	  
	  public String getEmail() {
	      return email;
	  }
	  
	  public void setUpdateByEmail(boolean updateByEmail) {
	      this.updateByEmail = updateByEmail;
	  }
	 
	  public boolean isUpdateByEmail() {
	    return updateByEmail;
	  }
	  
	  public Set<Posts> getPosts() {
		  return posts;
	  }
	  
	  public Collection<Users> getFriends() {
		  return friends;
	  }
	  public void setFriends(Collection<Users> friends){
		  this.friends = friends;
	  }
	  
	  public void addFriend(Users user) {
		  friends.add(user);
	  }

	  public String getFaculty() {
			  return faculty;
		  }
		  
		  public void setFaculty(String faculty) {
			  this.faculty = faculty;
		  }
		  
		  public String getGender() {
			  return gender;
		  }
		  
		  public void setGender(String gender) {
			  this.gender = gender;
		  }
		  
		  public void setYear(String year) {
			  this.year = year;
		  }
		  
		  public String getYear() {
			  return year;
		  }
			
			public String getImageName() {
				return imageName;
			}
			
			public void setImageName(String imageName) {
				this.imageName =imageName;
			}
			
			public void setPath(String path) {
				this.path = path;
			}
			
			public String getPath() {
				return path;
			}
			
			public String getNationality() {
				return nationality;
			}
			
			public void setNationality(String nationality) {
				this.nationality = nationality;
			}
			
			public String getMajor() {
				return major;
			}
			
			public void setMajor(String major) {
				this.major = major; 
			}
			
			public String getDegree() {
				return degree;
			}
			
			public void setDegree(String degree) {
				this.degree = degree;
			}
			
			public MultipartFile getUserImage() {
				return userImage;
			}
			public void setUserImage(MultipartFile userImage) {
				this.userImage = userImage;
			}
			
			public void setAdmin(int isAdmin) {
				this.isAdmin = isAdmin;
			}
			
			public int getAdmin() {
				return isAdmin;
			}
			
			/*public ArrayList<String> getFollowers() {
				return followers;
			}
			
			public void setFollowers(ArrayList<String> followers) {
				this.followers= followers;
			}*/
		 
}