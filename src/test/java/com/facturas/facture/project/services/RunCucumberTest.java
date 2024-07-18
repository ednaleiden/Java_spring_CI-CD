package com.facturas.facture.project.services;

import io.cucumber.junit.CucumberOptions;

@CucumberOptions(features = "src/test/resources/features", glue = "com.facturas.facture.project")
public class RunCucumberTest {
}
