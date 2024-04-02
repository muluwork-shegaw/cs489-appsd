import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Collectors;

public class MainApp {
    private static final SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

    public static void main(String[] args) throws Exception {
        List<Employee> employees = initializeEmployees();

        // Print all employees in JSON format
        printAllEmployeesInJson(employees);

        // Print the Monthly Upcoming Enrollees report in JSON format
        printUpcomingEnrolleesInJson(employees);
    }

    private static List<Employee> initializeEmployees() throws ParseException {
        List<Employee> employees = new ArrayList<>();
        employees.add(new Employee(1, "Daniel", "Agar", parseDate("2018-01-17"), parseBigDecimal("105945.50"), new PensionPlan("EX1089", parseDate("2023-01-17"), parseBigDecimal("100.00"))));
        employees.add(new Employee(2, "Benard", "Shaw", parseDate("2019-04-03"), parseBigDecimal("197750.00"), null));
        employees.add(new Employee(3, "Carly", "Agar", parseDate("2014-05-16"), parseBigDecimal("842000.75"), new PensionPlan("SM2307", parseDate("2019-11-04"), parseBigDecimal("1555.50"))));
        employees.add(new Employee(4, "Wesley", "Schneider", parseDate("2019-05-02"), parseBigDecimal("74500.00"), null));
        return employees;
    }

    private static void printAllEmployeesInJson(List<Employee> employees) throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        mapper.enable(SerializationFeature.INDENT_OUTPUT);
        employees.sort(Comparator.comparing(Employee::getLastName)
                .thenComparing(Employee::getYearlySalary).reversed());
        System.out.println("\n ******************* This the list of all employee *******************");
        System.out.println(mapper.writeValueAsString(employees));
    }

    private static void printUpcomingEnrolleesInJson(List<Employee> employees) throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        mapper.enable(SerializationFeature.INDENT_OUTPUT);

        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.MONTH, 1);
        cal.set(Calendar.DAY_OF_MONTH, 1);
        Date startOfNextMonth = cal.getTime();

        cal.add(Calendar.MONTH, 1);
        cal.add(Calendar.DAY_OF_MONTH, -1);
        Date endOfNextMonth = cal.getTime();

        List<Employee> upcomingEnrollees = employees.stream()
                .filter(e -> e.getPensionPlan() == null)
                .filter(e -> {
                    Date fiveYearsAfterEmployment = addYears(e.getEmploymentDate(), 5);
                    return (fiveYearsAfterEmployment.equals(startOfNextMonth) || fiveYearsAfterEmployment.after(startOfNextMonth)) &&
                            (fiveYearsAfterEmployment.equals(endOfNextMonth) || fiveYearsAfterEmployment.before(endOfNextMonth));
                })
                .sorted(Comparator.comparing(Employee::getEmploymentDate))
                .collect(Collectors.toList());

        System.out.println("\n\n ******************* This the list of The upcoming employee ******************* ");

        System.out.println(mapper.writeValueAsString(upcomingEnrollees));
    }

    private static BigDecimal parseBigDecimal(String value) {
        return new BigDecimal(value.replace(",", ""));
    }

    private static Date parseDate(String dateString) throws ParseException {
        return sdf.parse(dateString);
    }

    private static Date addYears(Date date, int years) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(Calendar.YEAR, years);
        return cal.getTime();
    }
}

