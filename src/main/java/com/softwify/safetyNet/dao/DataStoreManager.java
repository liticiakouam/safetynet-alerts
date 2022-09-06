package com.softwify.safetyNet.dao;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.softwify.safetyNet.modele.FireStation;
import com.softwify.safetyNet.modele.MedicalRecord;
import com.softwify.safetyNet.modele.Person;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;
import org.springframework.util.FileCopyUtils;

import java.io.InputStream;
import java.util.List;
import java.util.logging.Logger;

import static java.util.logging.Logger.getLogger;

@Component
public class DataStoreManager implements CommandLineRunner {private Logger logger = getLogger(DataStoreManager.class.getSimpleName());
    private DataStore dataStore;
    @Override
    public void run(String... args) throws Exception {
        // Read file from resources folder
        ClassPathResource resource = new ClassPathResource("data.json");
        InputStream inputStream = resource.getInputStream();

        dataStore = new ObjectMapper().readValue(inputStream, DataStore.class);
    }

    public List<Person> getPersons() {
        return dataStore.getPersons();
    }

    private static class DataStore {
        private List<Person> persons;
        private List<FireStation> firestations;
        private List<MedicalRecord> medicalrecords;

        public List<Person> getPersons() {
            return persons;
        }

        public void setPersons(List<Person> persons) {
            this.persons = persons;
        }

        public List<FireStation> getFirestations() {
            return firestations;
        }

        public void setFirestations(List<FireStation> firestations) {
            this.firestations = firestations;
        }

        public List<MedicalRecord> getMedicalrecords() {
            return medicalrecords;
        }

        public void setMedicalrecords(List<MedicalRecord> medicalrecords) {
            this.medicalrecords = medicalrecords;
        }
    }
}