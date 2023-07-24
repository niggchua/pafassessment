package vttp2023.assessment.paf.batch3.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import vttp2023.assessment.paf.batch3.models.Beer;
import vttp2023.assessment.paf.batch3.models.Brewery;
import vttp2023.assessment.paf.batch3.models.Style;

@Repository
public class BeerRepository {

	@Autowired
	JdbcTemplate jdbc;

	private final String getStylesSql = "select s.id, s.style_name, count(*) from beers as b inner join styles as s on b.style_id = s.id order by count(*) DESC, s.style_name ASC";

	// DO NOT CHANGE THE SIGNATURE OF THIS METHOD
	public List<Style> getStyles() {
		// TODO: Task 2


		List<Style> getAllStyles = jdbc.query(getStylesSql, BeanPropertyRowMapper.newInstance(Style.class));

		
		return getAllStyles;
	}
	

	private final String getBeerByStylesSql = "select b.id, b.name, b.descript, br.id, br.name from beers as b inner join styles as s on b.style_id = s.id inner join breweries as br on b.brewery_id=br.id where s.style_name = ? order by b.name ASC";

	// DO NOT CHANGE THE METHOD'S NAME OR THE RETURN TYPE OF THIS METHOD
	public List<Beer> getBreweriesByBeer(String styleName) {
		// TODO: Task 3

		
		List<Beer> beerList = jdbc.query(getBeerByStylesSql, BeanPropertyRowMapper.newInstance(Beer.class), styleName);
		if (beerList.isEmpty()){

			throw new IllegalStateException("No beers found for this style");
		}
			return beerList;
		} 
		

	// DO NOT CHANGE THE METHOD'S NAME OR THE RETURN TYPE OF THIS METHOD
	public Optional<Brewery> getBeersFromBrewery(/* You can add any number of parameters here */) {
		// TODO: Task 4

		return Optional.empty();
	}
}
