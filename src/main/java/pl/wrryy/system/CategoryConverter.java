package pl.wrryy.system;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import pl.wrryy.dao.CategoryRepository;
import pl.wrryy.entity.Category;

public class CategoryConverter implements Converter<String, Category> {
        @Autowired
        private CategoryRepository categoryDao;
        @Override
        public Category convert(String source) {
            Category group = categoryDao.findOne(Integer.parseInt(source));
            return group;
        }
    }
