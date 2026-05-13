import networkx as nx

class GraphFloyd:
    def __init__(self, file_path):
        self.G = nx.DiGraph()
        self.load_graph(file_path)
    def load_graph(self, file_path):
        with open(file_path, "r") as f:
            for line in f:
                parts = line.strip().split()
                if len(parts) == 3:
                    origin, dest, dist = parts
                    self.G.add_edge(origin, dest, weight=float(dist))
    def compute_floyd(self):
        self.dist = dict(nx.floyd_warshall(self.G))
        self.paths = dict(nx.floyd_warshall_predecessor_and_distance(self.G)[0])
    def get_distance(self, u, v):
        return self.dist[u][v]
    def get_path(self, u, v):
        try:
            return nx.shortest_path(self.G, u, v, weight="weight")
        except nx.NetworkXNoPath:
            return []
    def get_center(self):
        max_distances = {}

        for node in self.G.nodes:
            max_dist = max(self.dist[node].values())
            max_distances[node] = max_dist
        return min(max_distances, key=max_distances.get)
    def remove_edge(self, u, v):
        if self.G.has_edge(u, v):
            self.G.remove_edge(u, v)
    def add_edge(self, u, v, weight):
        self.G.add_edge(u, v, weight=weight)