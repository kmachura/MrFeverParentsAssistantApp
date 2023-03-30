package Com.MrFever.Dao;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class AddMedicineDoseDaoTest {
    @Test
    void shouldThrowNullPointerExceptionsWithoutDbConnection() {
        AddMedicineDoseDao addMedicineDoseDao = new AddMedicineDoseDao();
        assertThrows(NullPointerException.class,
                () -> {
                    addMedicineDoseDao.selectMedicines();
                });
    }
  
}