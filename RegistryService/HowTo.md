# How to configure microservices
1. Create all microservices projects
	- Add Dependencies
	<dependency>
     		 <groupId>org.springframework.cloud</groupId>
      		<artifactId>spring-cloud-starter</artifactId>
   	 </dependency>
   	 <dependency>
     		 <groupId>org.springframework.cloud</groupId>
     		 <artifactId>spring-cloud-starter-netflix-eureka-client</artifactId>
  	  </dependency>

1. Create a service registery project
	- Add Dependencies
		`<dependency>
			<groupId>org.springframework.cloud</groupId>
			<artifactId>spring-cloud-starter</artifactId>
		</dependency>
		
		<dependency>
			<groupId>org.springframework.cloud</groupId>
			<artifactId>spring-cloud-starter-netflix-eureka-server</artifactId>
		</dependency>`
		
- Annotate the main class with **@EnableEurekaServer**
- add configuration to the application.properties
		- server.port=8761
		- eureka.instance.hostname=localhost
		- eureka.client.fetch-registry=false
		- eureka.client.register-with-eureka=false
		
		
## To Enable service calling by its name
add annotation **@LoadBalanced** the class where you have created the 
**RestTemplate** bean

		