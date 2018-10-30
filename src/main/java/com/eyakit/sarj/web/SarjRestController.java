package com.eyakit.sarj.web;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.mvc.ControllerLinkBuilder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.eyakit.sarj.exception.InternalServerException;
import com.eyakit.sarj.exception.UserNotFoundException;
import com.eyakit.sarj.model.Brand;
import com.eyakit.sarj.model.User;
import com.eyakit.sarj.service.SarjService;

@RestController
@RequestMapping("/rest")
public class SarjRestController {
	
	@Autowired
	private SarjService sarjService;
	
	@RequestMapping(method = RequestMethod.GET, value = "/users")
	public ResponseEntity<List<User>> getUsers() {
		List<User> users = sarjService.findUsers();
		return ResponseEntity.ok(users);
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/user/{id}")
	public ResponseEntity<?> getUser(@PathVariable("id") Long id) {
		try {
			User user = sarjService.findUser(id);
			return ResponseEntity.ok(user);
		} catch (UserNotFoundException ex) {
			return ResponseEntity.notFound().build();
		}
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/user/{id}",produces="application/json")
	public ResponseEntity<?> getUserAsHateoasResource(@PathVariable("id") Long id) {
		try {
			User owner = sarjService.findUser(id);
			Link self = ControllerLinkBuilder.linkTo(SarjRestController.class).slash("/user/" + id).withSelfRel();
			Link create = ControllerLinkBuilder.linkTo(SarjRestController.class).slash("/user").withRel("create");
			Link update = ControllerLinkBuilder.linkTo(SarjRestController.class).slash("/user/" + id).withRel("update");
			Link delete = ControllerLinkBuilder.linkTo(SarjRestController.class).slash("/user/" + id).withRel("delete");			
			Resource<User> resource = new Resource<User>(owner, self,create,update,delete);
			return ResponseEntity.ok(resource);
		} catch (UserNotFoundException ex) {
			return ResponseEntity.notFound().build();
		}
	}

	@RequestMapping(method = RequestMethod.GET, value = "/user")
	public ResponseEntity<List<User>> getUsers(@RequestParam("ln") String lastName) {
		List<User> users = sarjService.findUsers(lastName);
		return ResponseEntity.ok(users);
	}
	
	@RequestMapping(method = RequestMethod.POST, value = "/user")
	public ResponseEntity<URI> createUser(@RequestBody User user) {
		try {
			sarjService.createUser(user);
			Long id = user.getId();
			URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(id).toUri();
			return ResponseEntity.created(location).build();
		} catch (Exception ex) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}
	
	@RequestMapping(method = RequestMethod.PUT, value = "/user/{id}")
	public ResponseEntity<?> updateUser(@PathVariable("id") Long id, @RequestBody User userRequest) {
		try {
			User user = sarjService.findUser(id);
			user.setFirstName(userRequest.getFirstName());
			user.setLastName(userRequest.getLastName());
			sarjService.updateUser(user);
			return ResponseEntity.ok().build();
		} catch (UserNotFoundException ex) {
			return ResponseEntity.notFound().build();
		} catch (Exception ex) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}
	
	@RequestMapping(method = RequestMethod.DELETE, value = "/user/{id}")
	@ResponseStatus(HttpStatus.OK)
	public void deleteUser(@PathVariable("id") Long id) {
		try {
			sarjService.deleteUser(id);
		} catch (UserNotFoundException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new InternalServerException(ex);
		}
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/brands")
	public ResponseEntity<List<Brand>> getBrands() {
		List<Brand> brands = sarjService.findBrands();
		return ResponseEntity.ok(brands);
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/brand/{id}")
	public ResponseEntity<?> getBrand(@PathVariable("id") Long id) {
		try {
			Brand brand = sarjService.findBrand(id);
			return ResponseEntity.ok(brand);
		} catch (UserNotFoundException ex) {
			return ResponseEntity.notFound().build();
		}
	}
	
	@RequestMapping(method = RequestMethod.POST, value = "/brand")
	public ResponseEntity<URI> createBrand(@RequestBody Brand brand) {
		try {
			sarjService.createBrand(brand);
			Long id = brand.getId();
			URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(id).toUri();
			return ResponseEntity.created(location).build();
		} catch (Exception ex) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}
	
	@RequestMapping(method = RequestMethod.PUT, value = "/brand/{id}")
	public ResponseEntity<?> updateBrand(@PathVariable("id") Long id, @RequestBody Brand brandRequest) {
		try {
			Brand brand = sarjService.findBrand(id);
			brand.setName(brandRequest.getName());
			sarjService.updateBrand(brand);
			return ResponseEntity.ok().build();
		} catch (UserNotFoundException ex) {
			return ResponseEntity.notFound().build();
		} catch (Exception ex) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}
}
