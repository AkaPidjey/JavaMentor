package Java_Core_Module_4.Task_4_2_8;

public class Main {
    public static void moveRobot(RobotConnectionManager robotConnectionManager, int toX, int toY) {
        RobotConnection rc = null;

        for (int i = 0; i < 3; i++) {
            try {
                rc = robotConnectionManager.getConnection();
                rc.moveRobotTo(toX, toY);
                break;
            } catch (RobotConnectionException e) {
                if (i == 2) {
                    throw new RobotConnectionException("Нет связи");
                }
            } finally {
                if (rc != null) {
                    try {
                        rc.close();
                    } catch (RobotConnectionException e) {
                        System.out.println("Ошибка");
                    }
                }
            }
        }
    }
}



/* Решение через try с ресурсами

    boolean connect = false;

    for (int i = 0; i < 3; i++) {
        try (RobotConnection rc = robotConnectionManager.getConnection()) {
           rc.moveRobotTo(toX, toY);
           connect = true;
           break;
        } catch (RobotConnectionException e) {
        }
    }
    if (!connect) {
            throw new RobotConnectionException("Ошибка");
    }

 */