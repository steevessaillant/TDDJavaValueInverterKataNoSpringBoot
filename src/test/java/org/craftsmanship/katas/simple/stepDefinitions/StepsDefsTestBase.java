package org.craftsmanship.katas.simple.stepDefinitions;

import org.junit.runner.RunWith;
import org.springframework.boot.test.IntegrationTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTestContextBootstrapper;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.BootstrapWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@BootstrapWith(SpringBootTestContextBootstrapper.class)
@SpringBootTest
@Configuration
@ComponentScan(basePackages = { "org.craftsmanship.katas.simple.stepDefinitions" })
public abstract class StepsDefsTestBase extends SpringBootTestContextBootstrapper {

}

