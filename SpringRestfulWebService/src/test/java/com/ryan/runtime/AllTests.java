package com.ryan.runtime;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import com.ryan.test.rest.controller.CountryControllerTest;

@RunWith(Suite.class)
@SuiteClasses({CountryControllerTest.class})
public class AllTests {

}
