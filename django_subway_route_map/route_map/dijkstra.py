from subway_location_graph import subway_location_graph
from subway_location_name import subway_location_name
import heapq


def dijkstra(start: str, end: str) -> int:
    INF = int(1e10)
    distance = [INF] * 643

    q = []
    start_idx = subway_location_name[start]
    heapq.heappush(q, (0, start_idx))
    distance[start_idx] = 0

    while q:
        dist, now = heapq.heappop(q)
        if distance[now] < dist:
            continue
        for i in subway_location_graph[now]:
            cost = dist + i[1]
            if cost < distance[i[0]]:
                distance[i[0]] = cost
                heapq.heappush(q, (cost, i[0]))
    end_idx = subway_location_name[end]
    return distance[end_idx]


