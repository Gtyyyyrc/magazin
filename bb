items = [
    {"name": "Яблоко", "price": 100, "stock": 10},
    {"name": "Банан", "price": 50, "stock": 5},
]

def buy_item(item_name, quantity):
    item = None
    for i in items:
        if i["name"] == item_name:
            item = i
            break
    if not item:
        print("Товар не найден!")
        return
    if item["stock"] < quantity:
        print("Недостаточно товара на складе!")
        return
    item["stock"] -= quantity
    total_cost = item["price"] * quantity
    print(f"Вы купили {quantity} {item_name}(ов) на сумму {total_cost} тенге.")
    with open("transactions.txt", "a") as f:
        f.write(f"{item_name} - {quantity} шт - {total_cost} тенге\n")

print("Доступные товары:")
for i in items:
    print(f"{i['name']}: {i['price']} тенге (Остаток: {i['stock']})")

buy_item("Яблоко", 2)
buy_item("Банан", 1)
buy_item("Апельсин", 1)

print("\nИстория покупок:")
with open("transactions.txt", "r") as f:
    for line in f:
        print(line.strip())
