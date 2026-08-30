package tests;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import pages.SearchPage;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class SearchTest extends BaseTest {

    @Test
    void searchingForExistingProductReturnsResults() {
        SearchPage searchPage = new SearchPage(driver);
        searchPage.open();

        searchPage.searchFor("Dress");

        assertTrue(searchPage.getResultsHeadingText().equalsIgnoreCase("Searched Products"),
                "Expected the results heading to read 'Searched Products' (case-insensitive)");
        assertTrue(searchPage.getResultCount() > 0,
                "Expected at least one product for a search term known to exist");
    }

    @ParameterizedTest(name = "search term=\"{0}\" -> expected results with count>0? {1}")
    @CsvSource({
            "Dress, true",
            "zzznonexistentproduct123, false",
            "'', true"
    })
    void searchPartitionsBehaveAsExpected(String term, boolean expectResults) {
        SearchPage searchPage = new SearchPage(driver);
        searchPage.open();

        searchPage.searchFor(term);

        int count = searchPage.getResultCount();
        if (expectResults) {
            assertTrue(count > 0, "Expected results for term: " + term);
        } else {
            assertEquals(0, count, "Expected no results for term: " + term);
        }
    }
}
