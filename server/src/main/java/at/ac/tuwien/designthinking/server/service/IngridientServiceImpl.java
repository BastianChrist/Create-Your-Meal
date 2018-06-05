package at.ac.tuwien.designthinking.server.service;

import at.ac.tuwien.designthinking.server.persistence.IngridientDAO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Bastian on 27.05.2018.
 */
@Service
public class IngridientServiceImpl implements IngridientService{
    private static final Logger LOGGER = LoggerFactory.getLogger(IngridientService.class);
    private static IngridientDAO ingridientDAO;

    @Autowired
    public IngridientServiceImpl(IngridientDAO ingridientDAO){this.ingridientDAO = ingridientDAO;}

    //TODO
    @Override
    public Object getById(int id) throws ServiceException {
        return null;
    }

    @Override
    public List getAll() throws ServiceException {
        return null;
    }

    @Override
    public List getByCategory() throws ServiceException {
        return null;
    }
}
