package Java_Core_Module_3;

import java.math.*;
import java.util.Arrays;

public class Task_3_3_13 {
        public static void main(String[] args) {
            Robot robot = new Robot(0,0, Direction.DOWN);
            moveRobot(robot, -5, 20);
            System.out.println(robot.getX());
            System.out.println(robot.getY());
        }

        public enum Direction {
            UP,
            DOWN,
            LEFT,
            RIGHT
        }

        public static class Robot {
            int x;
            int y;
            Direction dir;

            public Robot (int x, int y, Direction dir) {
                this.x = x;
                this.y = y;
                this.dir = dir;
            }

            public Direction getDirection() {return dir;}

            public int getX() {return x;}

            public int getY() {return y;}

            public void turnLeft() {
                if      (dir == Direction.UP)    {dir = Direction.LEFT;}
                else if (dir == Direction.DOWN)  {dir = Direction.RIGHT;}
                else if (dir == Direction.LEFT)  {dir = Direction.DOWN;}
                else if (dir == Direction.RIGHT) {dir = Direction.UP;}
            }

            public void turnRight() {
                if      (dir == Direction.UP)    {dir = Direction.RIGHT;}
                else if (dir == Direction.DOWN)  {dir = Direction.LEFT;}
                else if (dir == Direction.LEFT)  {dir = Direction.UP;}
                else if (dir == Direction.RIGHT) {dir = Direction.DOWN;}
            }

            public void stepForward() {
                if (dir == Direction.UP)    {y++;}
                if (dir == Direction.DOWN)  {y--;}
                if (dir == Direction.LEFT)  {x--;}
                if (dir == Direction.RIGHT) {x++;}
            }
        }

        public static void moveRobot(Robot robot, int toX, int toY) {
            Direction temp = robot.getDirection();
            int x1 = robot.getX();
            int y1 = robot.getY();

            if (x1 < toX) {
                if (temp == Direction.RIGHT) {
                    while (x1 != toX) {
                        robot.stepForward();
                        x1++;
                    }
                } else if (temp == Direction.LEFT) {
                    robot.turnLeft();
                    robot.turnLeft();
                    while (x1 != toX) {
                        robot.stepForward();
                        x1++;
                    }
                } else if (temp == Direction.DOWN) {
                    robot.turnLeft();
                    while (x1 != toX) {
                        robot.stepForward();
                        x1++;
                    }
                } else if (temp == Direction.UP) {
                    robot.turnRight();
                    while (x1 != toX) {
                        robot.stepForward();
                        x1++;
                    }
                }
            } else {
                if (temp == Direction.RIGHT) {
                    robot.turnLeft();
                    robot.turnLeft();
                    while (x1 != toX) {
                        robot.stepForward();
                        x1--;
                    }
                } else if (temp == Direction.LEFT) {
                    while (x1 != toX) {
                        robot.stepForward();
                        x1--;
                    }
                } else if (temp == Direction.DOWN) {
                    robot.turnRight();
                    while (x1 != toX) {
                        robot.stepForward();
                        x1--;
                    }
                } else if (temp == Direction.UP) {
                    robot.turnLeft();
                    while (x1 != toX) {
                        robot.stepForward();
                        x1--;
                    }
                }
            }

            temp = robot.getDirection();

            if (y1 < toY) {
                if (temp == Direction.RIGHT) {
                    robot.turnLeft();
                    while (y1 != toY) {
                        robot.stepForward();
                        y1++;
                    }
                } else if (temp == Direction.LEFT) {
                    robot.turnRight();
                    while (y1 != toY) {
                        robot.stepForward();
                        y1++;
                    }
                } else if (temp == Direction.DOWN) {
                    robot.turnLeft();
                    robot.turnLeft();
                    while (y1 != toY) {
                        robot.stepForward();
                        y1++;
                    }
                } else if (temp == Direction.UP) {
                    while (y1 != toY) {
                        robot.stepForward();
                        y1++;
                    }
                }
            } else {
                if (temp == Direction.RIGHT) {
                    robot.turnRight();
                    while (y1 != toY) {
                        robot.stepForward();
                        y1--;
                    }
                } else if (temp == Direction.LEFT) {
                    robot.turnLeft();
                    while (y1 != toY) {
                        robot.stepForward();
                        y1--;
                    }
                } else if (temp == Direction.DOWN) {
                    while (y1 != toY) {
                        robot.stepForward();
                        y1--;
                    }
                } else if (temp == Direction.UP) {
                    robot.turnLeft();
                    robot.turnLeft();
                    while (y1 != toY) {
                        robot.stepForward();
                        y1--;
                    }
                }
            }
        }
}
