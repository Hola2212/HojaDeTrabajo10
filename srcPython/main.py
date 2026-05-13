from graph_floyd import GraphFloyd


def main():
    g = GraphFloyd("../src/resources/guategrafo.txt")
    g.compute_floyd()
    while True:
        print("\n1. Ruta más corta")
        print("2. Centro del grafo")
        print("3. Modificar grafo")
        print("4. Salir")

        op = input("> ")

        if op == "1":
            a = input("Origen: ")
            b = input("Destino: ")

            print("Ruta:", g.get_path(a, b))
            print("Distancia:", g.get_distance(a, b))

        elif op == "2":
            print("Centro:", g.get_center())
        elif op == "3":
            print("1. Eliminar conexión")
            print("2. Agregar conexión")
            sub = input("> ")
            if sub == "1":
                a = input("Origen: ")
                b = input("Destino: ")
                g.remove_edge(a, b)
            else:
                a = input("Origen: ")
                b = input("Destino: ")
                d = float(input("Distancia: "))
                g.add_edge(a, b, d)
            g.compute_floyd()
        else:
            break
if __name__ == "__main__":
    main()