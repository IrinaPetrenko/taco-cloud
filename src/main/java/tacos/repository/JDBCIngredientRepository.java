package tacos.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import tacos.domain.Ingredient;

import java.sql.ResultSet;
import java.sql.SQLException;

@Repository
public class JDBCIngredientRepository{

//    private JdbcTemplate jdbcTemplate;
//
//    @Autowired
//    public JDBCIngredientRepository(JdbcTemplate jdbc) {
//        this.jdbcTemplate = jdbc;
//    }
//
//    @Override
//    public Iterable<Ingredient> findAll() {
//        return jdbcTemplate.query("SELECT id, name, type FROM Ingredient",
//                this::mapRowToIngredient);
//    }
//
//    @Override
//    public Ingredient findOne(String id) {
//        return jdbcTemplate.queryForObject("SELECT id, name, type FROM Ingredient WHERE id = ?",
//                this::mapRowToIngredient, id);
//    }
//
//    @Override
//    public Ingredient save(Ingredient ingredient) {
//        jdbcTemplate.update("INSERT INTO Ingredient (id, name, type) values (?, ?, ?)",
//                ingredient.getId(),
//                ingredient.getName(),
//                ingredient.getType().toString());
//        return ingredient;
//    }
//
//    private Ingredient mapRowToIngredient(ResultSet rs, int rowNum) throws SQLException {
//        return new Ingredient(
//                rs.getString("id"),
//                rs.getString("name"),
//                Ingredient.Type.valueOf(rs.getString("type"))
//        );
//    }
}
