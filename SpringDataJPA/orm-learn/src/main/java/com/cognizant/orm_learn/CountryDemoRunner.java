package com.cognizant.ormlearn;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.cognizant.ormlearn.model.Country;
import com.cognizant.ormlearn.service.CountryService;


@Component
public class CountryDemoRunner implements CommandLineRunner {

    @Autowired
    private CountryService countryService;

    @Override
    public void run(String... args) throws Exception {
        System.out.println("\n====== Spring Data JPA - Country Management Demo ======\n");

        try {
            System.out.println("--- 1. Adding New Countries ---");
            Country country1 = new Country("IN", "India");
            Country country2 = new Country("US", "United States");
            Country country3 = new Country("UK", "United Kingdom");
            
            countryService.addCountry(country1);
            countryService.addCountry(country2);
            countryService.addCountry(country3);
            
            System.out.println("✓ Countries added successfully\n");

            System.out.println("--- 2. Find Country by Code (O/R Mapping) ---");
            Country foundCountry = countryService.getCountryByCode("IN");
            if (foundCountry != null) {
                System.out.println("✓ Found: " + foundCountry);
                System.out.println("  Code: " + foundCountry.getCode());
                System.out.println("  Name: " + foundCountry.getName());
                System.out.println("  (This demonstrates O/R Mapping - Java object ↔ Database table)\n");
            }

            
            System.out.println("--- 3. Get All Countries ---");
            countryService.getAllCountries().forEach(c -> System.out.println("✓ " + c));
            System.out.println();

       
            System.out.println("--- 4. Search by Name Containing 'United' (Derived Query) ---");
            countryService.search("United").forEach(c -> System.out.println("✓ " + c));
            System.out.println();

            System.out.println("--- 5. Search using JPQL (Hibernate Query Language) ---");
            System.out.println("Query: SELECT c FROM Country c WHERE c.name LIKE %:name%");
            countryService.searchUsingJPQL("India").forEach(c -> System.out.println("✓ " + c));
            System.out.println();

            
            System.out.println("--- 6. Search using Native SQL Query ---");
            System.out.println("Query: SELECT * FROM country WHERE co_name LIKE CONCAT('%', :name, '%')");
            countryService.searchUsingNativeSQL("United").forEach(c -> System.out.println("✓ " + c));
            System.out.println();

         
            System.out.println("--- 7. Search and Sort Alphabetically (JPQL with ORDER BY) ---");
            countryService.searchAndSort("United").forEach(c -> System.out.println("✓ " + c));
            System.out.println();

            System.out.println("--- 8. Search by Starting Letter 'U' (Query Derivation) ---");
            countryService.startsWith("U").forEach(c -> System.out.println("✓ " + c));
            System.out.println();

    
            System.out.println("--- 9. Update Country ---");
            Country updateCountry = countryService.getCountryByCode("IN");
            if (updateCountry != null) {
                updateCountry.setName("Republic of India");
                countryService.updateCountry(updateCountry);
                System.out.println("✓ Updated: " + updateCountry + "\n");
            }

    
            System.out.println("--- 10. Get All Countries Sorted (Native SQL) ---");
            System.out.println("Query: SELECT * FROM country ORDER BY co_name ASC");
            countryService.getAllCountriesSorted().forEach(c -> System.out.println("✓ " + c));
            System.out.println();

            System.out.println("====== Assessment Requirements Completed ======");
            System.out.println("✓ Implement services for managing Country");
            System.out.println("✓ Find a country based on country code");
            System.out.println("✓ Add a new country");
            System.out.println("✓ Demonstrate HQL/JPQL queries");
            System.out.println("✓ Demonstrate Native SQL queries");
            System.out.println("✓ Demonstrate O/R (Object-Relational) Mapping");
            System.out.println("=============================================\n");

        } catch (Exception e) {
            System.err.println("Error during demo: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
