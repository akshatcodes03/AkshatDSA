class Solution:
    def secondsBetweenTimes(self, startTime, endTime):

        h1 = int(startTime[0:2])
        m1 = int(startTime[3:5])
        s1 = int(startTime[6:8])

        h2 = int(endTime[0:2])
        m2 = int(endTime[3:5])
        s2 = int(endTime[6:8])

        return (h2 - h1) * 3600 + (m2 - m1) * 60 + (s2 - s1)