import java.util.*;

class Workout {
    private String name;
    private int duration; // in minutes

    public Workout(String name, int duration) {
        this.name = name;
        this.duration = duration;
    }

    public String getName() {
        return name;
    }

    public int getDuration() {
        return duration;
    }
}

class WorkoutLog {
    private Map<String, List<Workout>> log;

    public WorkoutLog() {
        log = new HashMap<>();
    }

    public void addWorkout(String day, Workout workout) {
        if (!log.containsKey(day)) {
            log.put(day, new ArrayList<>());
        }
        log.get(day).add(workout);
    }

    public Map<String, List<Workout>> getLog() {
        return log;
    }
}

public class WorkoutTracker {
    // ... (Previous code remains unchanged)
    private static Map<String, Map<String, List<Workout>>> preListedWorkouts = new HashMap<>();

    static {
        // For thin people
        Map<String, List<Workout>> thinWorkouts = new HashMap<>();
        thinWorkouts.put("Monday", Arrays.asList(
                new Workout("Jogging", 30),
                new Workout("Stretching", 15),
                new Workout("Yoga", 20)
        ));
        thinWorkouts.put("Tuesday", Arrays.asList(
                new Workout("Swimming", 40),
                new Workout("Pilates", 25),
                new Workout("Cycling", 45)
        ));
        thinWorkouts.put("Wednesday", Arrays.asList(
                new Workout("Running", 35),
                new Workout("Bodyweight Exercises", 30),
                new Workout("Dancing", 40)
        ));
        thinWorkouts.put("Thursday", Arrays.asList(
                new Workout("HIIT", 25),
                new Workout("Walking", 20),
                new Workout("Strength Training", 45)
        ));
        thinWorkouts.put("Friday", Arrays.asList(
                new Workout("Jump Rope", 15),
                new Workout("Rowing", 30),
                new Workout("Kickboxing", 40)
        ));
        thinWorkouts.put("Saturday", Arrays.asList(
                new Workout("Circuit Training", 40),
                new Workout("Hiking", 60),
                new Workout("Aerobics", 35)
        ));
        thinWorkouts.put("Sunday", Arrays.asList(
                new Workout("Rest Day", 0)
        ));

        preListedWorkouts.put("Thin", thinWorkouts);

        // For slim people
        Map<String, List<Workout>> slimWorkouts = new HashMap<>();
        slimWorkouts.put("Monday", Arrays.asList(
                new Workout("Weightlifting", 45),
                new Workout("Cycling", 40),
                new Workout("Plank", 5)
        ));
        slimWorkouts.put("Tuesday", Arrays.asList(
                new Workout("Yoga", 30),
                new Workout("Running", 35),
                new Workout("Swimming", 40)
        ));
        slimWorkouts.put("Wednesday", Arrays.asList(
                new Workout("Pilates", 25),
                new Workout("HIIT", 20),
                new Workout("Jump Rope", 15)
        ));
        slimWorkouts.put("Thursday", Arrays.asList(
                new Workout("Rowing", 30),
                new Workout("Bodyweight Exercises", 30),
                new Workout("Dancing", 40)
        ));
        slimWorkouts.put("Friday", Arrays.asList(
                new Workout("Kickboxing", 40),
                new Workout("Hiking", 60),
                new Workout("Aerobics", 35)
        ));
        slimWorkouts.put("Saturday", Arrays.asList(
                new Workout("Circuit Training", 40),
                new Workout("Walking", 20),
                new Workout("Stretching", 15)
        ));
        slimWorkouts.put("Sunday", Arrays.asList(
                new Workout("Rest Day", 0)
        ));

        preListedWorkouts.put("Slim", slimWorkouts);

        // For overweight people
        Map<String, List<Workout>> overweightWorkouts = new HashMap<>();
        overweightWorkouts.put("Monday", Arrays.asList(
                new Workout("Walking", 20),
                new Workout("Stretching", 15),
                new Workout("Yoga", 20)
        ));
        overweightWorkouts.put("Tuesday", Arrays.asList(
                new Workout("Swimming", 40),
                new Workout("Pilates", 25),
                new Workout("Cycling", 45)
        ));
        overweightWorkouts.put("Wednesday", Arrays.asList(
                new Workout("Running", 35),
                new Workout("Bodyweight Exercises", 30),
                new Workout("Dancing", 40)
        ));
        overweightWorkouts.put("Thursday", Arrays.asList(
                new Workout("HIIT", 25),
                new Workout("Weightlifting", 45),
                new Workout("Jumping Jacks", 20)
        ));
        overweightWorkouts.put("Friday", Arrays.asList(
                new Workout("Rowing", 30),
                new Workout("Push-ups", 15),
                new Workout("Kickboxing", 40)
        ));
        overweightWorkouts.put("Saturday", Arrays.asList(
                new Workout("Circuit Training", 40),
                new Workout("Hiking", 60),
                new Workout("Aerobics", 35)
        ));
        overweightWorkouts.put("Sunday", Arrays.asList(
                new Workout("Rest Day", 0)
        ));

        preListedWorkouts.put("Overweight", overweightWorkouts);
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        WorkoutLog workoutLog = new WorkoutLog();

        System.out.println("Welcome to Workout Tracker!");

        while (true) {
            System.out.println("\nSelect your action:");
            System.out.println("1. Choose body type and log workouts for the week");
            System.out.println("2. View workout log for the week");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            if (choice == 3) {
                System.out.println("Exiting. Goodbye!");
                break;
            }

            switch (choice) {
                case 1:
                    System.out.println("\nSelect your body type:");
                    System.out.println("1. Thin");
                    System.out.println("2. Slim");
                    System.out.println("3. Overweight");
                    System.out.print("Enter your choice: ");
                    int bodyTypeChoice = scanner.nextInt();

                    if (bodyTypeChoice < 1 || bodyTypeChoice > 3) {
                        System.out.println("Invalid choice. Please try again.");
                        break;
                    }

                    String[] bodyTypes = {"", "Thin", "Slim", "Overweight"};
                    String bodyType = bodyTypes[bodyTypeChoice];

                    for (int i = 0; i < 7; i++) {
                        Calendar calendar = Calendar.getInstance();
                        calendar.add(Calendar.DATE, i);
                        int dayOfWeek = calendar.get(Calendar.DAY_OF_WEEK);

                        String[] weekDays = {"", "Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"};
                        String currentDay = weekDays[dayOfWeek];

                        List<Workout> workouts = preListedWorkouts.get(bodyType).get(currentDay);

                        if (workouts != null) {
                            System.out.println("Workouts for " + currentDay + ":");
                            for (int j = 0; j < workouts.size() && j < 5; j++) {
                                Workout currentWorkout = workouts.get(j);
                                System.out.println((j + 1) + ". " + currentWorkout.getName() + " (" + currentWorkout.getDuration() + " mins)");
                                workoutLog.addWorkout(currentDay, currentWorkout);
                            }
                        } else {
                            System.out.println("No workouts listed for " + currentDay);
                        }
                    }

                    System.out.println("Workouts logged successfully for the week!");
                    break;

                case 2:
               System.out.println("\nWorkout Log for the week:");
                Map<String, List<Workout>> log = workoutLog.getLog();

                if (log.isEmpty()) {
                    System.out.println("Workout log is empty for the week.");
                } else {
                    for (Map.Entry<String, List<Workout>> entry : log.entrySet()) {
                        System.out.println(entry.getKey() + ":");
                        for (Workout workout : entry.getValue()) {
                            System.out.println("- " + workout.getName() + " (" + workout.getDuration() + " mins)");
                        }
                    }
                }
                break;

                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
        }

        scanner.close();
    }
}
