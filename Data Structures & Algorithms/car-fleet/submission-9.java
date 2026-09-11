class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        // sort the cars by position first
        // so the car closer to finish line is first
        // now for each car calculate time of arrv
        // of any pos i > j, if time of i is < time of j, it means it will merge with j

        record Car(Integer pos, Integer speed) {};
        List<Car> carFleet = new ArrayList<>();

        for (int i = 0; i < position.length; i++) {
            carFleet.add(new Car(position[i], speed[i]));
        }

        carFleet.sort(Comparator.comparing(Car::pos));
        
        int result = 0;
        float currentSlowest = 0;
       // System.out.println(carFleet + " " +  carFleet.size());
        for (int i = carFleet.size() - 1; i >= 0; i--) {
            float time = (float)(target - carFleet.get(i).pos) / carFleet.get(i).speed;
     //       System.out.println(target + " " +  carFleet + " " +  time);
            if (time > currentSlowest) {
                result += 1;
                currentSlowest = time;
            }
        }
        return result;
    }
}
