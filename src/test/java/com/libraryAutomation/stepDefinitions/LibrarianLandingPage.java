package com.libraryAutomation.stepDefinitions;

import com.libraryAutomation.pages.PageBase;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class LibrarianLandingPage
{

    @Given("the librarian on the homepage")
    public void the_librarian_on_the_homepage() {

    }


    @Then("the user should see following modules")
    public void the_user_should_see_following_modules(io.cucumber.datatable.DataTable dataTable) {
        // Write code here that turns the phrase above into concrete actions
        // For automatic transformation, change DataTable to one of
        // E, List<E>, List<List<E>>, List<Map<K,V>>, Map<K,V> or
        // Map<K, List<V>>. E,K,V must be a String, Integer, Float,
        // Double, Byte, Short, Long, BigInteger or BigDecimal.
        //
        // For other transformations you can register a DataTableType.
        throw new io.cucumber.java.PendingException();
    }


}
