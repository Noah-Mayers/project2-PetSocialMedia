package dev.groupone.controllers;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import com.google.gson.Gson;

import dev.groupone.beans.Pet;
import dev.groupone.services.PetService;

@AutoConfigureMockMvc
@SpringBootTest(classes = dev.mayers.SpringMVC.PetSocialMediaApplication.class)
public class PetControllerTests {
	
	@MockBean
	PetService ps;
	
	@Autowired
	MockMvc mvc;
	
	public static Gson gson = new Gson();
	
	@Test
	public void getAllPets() throws Exception {
		Pet my = new Pet(1, "testname", "testtag", "testbio", null, null, null);
		Pet test = new Pet(2, "testname", "testtag", "testbio", null, null, null);
		List<Pet> pets = new ArrayList<>();
		pets.add(my);
		pets.add(test);
		Mockito.when(ps.getAllPets()).thenReturn(pets);
		mvc.perform(get("/pets")).andExpect(status().isOk());
	}
	
	@Test
	public void createPet() throws Exception {
		Pet testPet = new Pet(1, "testname", "testtag", "testbio", null, null, null);
		Mockito.when(ps.addPet(testPet)).thenReturn(testPet);
		mvc.perform(post("/pets").contentType(MediaType.APPLICATION_JSON).content(gson.toJson(testPet))).andExpect(status().isOk());
	}
	
	@Test
	public void getPetById() throws Exception {
		Pet testPet = new Pet(1, "testname", "testtag", "testbio", null, null, null);
		Mockito.when(ps.getPet(1)).thenReturn(testPet);
		mvc.perform(get("/pets/1")).andExpect(status().isOk());
	}
	
	@Test
	public void getPetByTag() throws Exception {
		Pet testPet = new Pet(1, "testname", "testtag", "testbio", null, null, null);
		Mockito.when(ps.getPet("testtag")).thenReturn(testPet);
		mvc.perform(get("/pets/search").param("tag", "testtag")).andExpect(status().isOk());
	}
	
	@Test
	public void updatePet() throws Exception {
		Pet testPet = new Pet(1, "testname", "testtag", "testbio", null, null, null);
		Mockito.when(ps.updatePet(testPet)).thenReturn(testPet);
		mvc.perform(put("/pets/1").contentType(MediaType.APPLICATION_JSON).content(gson.toJson(testPet))).andExpect(status().isOk());
	}
	
	@Test
	public void deletePet() throws Exception {
		Pet testPet = new Pet(1, "testname", "testtag", "testbio", null, null, null);
		Mockito.when(ps.deletePet(1)).thenReturn(true);
		mvc.perform(delete("/pets/1")).andExpect(status().isOk());
	}

}
