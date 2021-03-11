package fr.humanbooster.za.cadeau;

import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.noClasses;

import com.tngtech.archunit.core.domain.JavaClasses;
import com.tngtech.archunit.core.importer.ClassFileImporter;
import com.tngtech.archunit.core.importer.ImportOption;
import org.junit.jupiter.api.Test;

class ArchTest {

    @Test
    void servicesAndRepositoriesShouldNotDependOnWebLayer() {
        JavaClasses importedClasses = new ClassFileImporter()
            .withImportOption(ImportOption.Predefined.DO_NOT_INCLUDE_TESTS)
            .importPackages("fr.humanbooster.za.cadeau");

        noClasses()
            .that()
            .resideInAnyPackage("fr.humanbooster.za.cadeau.service..")
            .or()
            .resideInAnyPackage("fr.humanbooster.za.cadeau.repository..")
            .should()
            .dependOnClassesThat()
            .resideInAnyPackage("..fr.humanbooster.za.cadeau.web..")
            .because("Services and repositories should not depend on web layer")
            .check(importedClasses);
    }
}
