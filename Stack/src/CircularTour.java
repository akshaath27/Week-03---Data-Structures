class CircularTour {
    static int findStartingPoint(int[] petrol, int[] distance) {
        int totalSurplus = 0, currentSurplus = 0;
        int startIndex = 0;

        for (int i = 0; i < petrol.length; i++) {
            int netPetrol = petrol[i] - distance[i];
            totalSurplus += netPetrol;
            currentSurplus += netPetrol;

            if (currentSurplus < 0) {
                startIndex = i + 1;
                currentSurplus = 0;
            }
        }

        return (totalSurplus >= 0) ? startIndex : -1;
    }

    public static void main(String[] args) {
        int[] petrol = {4, 6, 7, 4};
        int[] distance = {6, 5, 3, 5};

        int start = findStartingPoint(petrol, distance);
        System.out.println(start == -1 ? "Tour not possible" : "Start at pump " + start);
    }
}
