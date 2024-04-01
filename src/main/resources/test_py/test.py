import threading
import requests


def deposit(wallet_id, amount):
    try:
        data = {
            "valletId": wallet_id,
            "operationType": "DEPOSIT",
            "amount": amount
        }
        response = requests.post("http://localhost:8080/api/v1/wallet", json=data)
        print(f"Deposit operation result: {response.status_code}")
    except Exception as e:
        print(f"Error during deposit operation: {e}")

def withdraw(wallet_id, amount):
    try:
        data = {
            "valletId": wallet_id,
            "operationType": "WITHDRAW",
            "amount": amount
        }
        response = requests.post("http://localhost:8080/api/v1/wallet", json=data)
        print(f"Withdraw operation result: {response.status_code}")
    except Exception as e:
        print(f"Error during withdraw operation: {e}")


def main():
    wallet_id = 1
    deposit_amount = 500
    withdraw_amount = 490

    threads = []

    threads.append(threading.Thread(target=deposit, args=(wallet_id, deposit_amount)))
    threads.append(threading.Thread(target=withdraw, args=(wallet_id, withdraw_amount)))

    threads.append(threading.Thread(target=deposit, args=(wallet_id, deposit_amount)))
    threads.append(threading.Thread(target=withdraw, args=(wallet_id, withdraw_amount)))

    threads.append(threading.Thread(target=deposit, args=(wallet_id, deposit_amount)))
    threads.append(threading.Thread(target=withdraw, args=(wallet_id, withdraw_amount)))

    threads.append(threading.Thread(target=deposit, args=(wallet_id, deposit_amount)))
    threads.append(threading.Thread(target=withdraw, args=(wallet_id, withdraw_amount)))

    threads.append(threading.Thread(target=deposit, args=(wallet_id, deposit_amount)))
    threads.append(threading.Thread(target=withdraw, args=(wallet_id, withdraw_amount)))


    threads.append(threading.Thread(target=deposit, args=(wallet_id, deposit_amount)))
    threads.append(threading.Thread(target=withdraw, args=(wallet_id, withdraw_amount)))

    threads.append(threading.Thread(target=deposit, args=(wallet_id, deposit_amount)))
    threads.append(threading.Thread(target=withdraw, args=(wallet_id, withdraw_amount)))

    threads.append(threading.Thread(target=deposit, args=(wallet_id, deposit_amount)))
    threads.append(threading.Thread(target=withdraw, args=(wallet_id, withdraw_amount)))

    threads.append(threading.Thread(target=deposit, args=(wallet_id, deposit_amount)))
    threads.append(threading.Thread(target=withdraw, args=(wallet_id, withdraw_amount)))

    threads.append(threading.Thread(target=deposit, args=(wallet_id, deposit_amount)))
    threads.append(threading.Thread(target=withdraw, args=(wallet_id, withdraw_amount)))


    threads.append(threading.Thread(target=deposit, args=(wallet_id, deposit_amount)))
    threads.append(threading.Thread(target=withdraw, args=(wallet_id, withdraw_amount)))

    threads.append(threading.Thread(target=deposit, args=(wallet_id, deposit_amount)))
    threads.append(threading.Thread(target=withdraw, args=(wallet_id, withdraw_amount)))

    threads.append(threading.Thread(target=deposit, args=(wallet_id, deposit_amount)))
    threads.append(threading.Thread(target=withdraw, args=(wallet_id, withdraw_amount)))

    threads.append(threading.Thread(target=deposit, args=(wallet_id, deposit_amount)))
    threads.append(threading.Thread(target=withdraw, args=(wallet_id, withdraw_amount)))

    threads.append(threading.Thread(target=deposit, args=(wallet_id, deposit_amount)))
    threads.append(threading.Thread(target=withdraw, args=(wallet_id, withdraw_amount)))

    for thread in threads:
        thread.start()

    for thread in threads:
        thread.join()


if __name__ == "__main__":
    main()
