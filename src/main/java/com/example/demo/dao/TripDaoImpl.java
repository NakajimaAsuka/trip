package com.example.demo.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Prefectures;

@Repository
public class TripDaoImpl implements TripDao {
	@Autowired
	JdbcTemplate jdbcTemplate;

	/**
	 *　都道府県名を取得
	 */
	@Override
	public List<Prefectures> getAll() {
		String sql = "SELECT prefectures FROM public.prefectures";
		Map<String, Object> resultMap = jdbcTemplate.queryForMap(sql);
		List<Prefectures> list = new ArrayList<>();
		resultMap.forEach((key, value) -> {
			Prefectures prefectures = new Prefectures();
			prefectures.setPrefectures(value.toString());
			list.add(prefectures);
		});
		return list;
	}

}
