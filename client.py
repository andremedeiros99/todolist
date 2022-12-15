import requests

url = "http://localhost:8080/api/tarefas"

def GET(ID):
    if ID == None:
        print('oi')
        return requests.get(url)
    else:
        print(f'{url}/{ID}')
        return requests.get(f'{url}/{ID}')

def POST(json):
    return requests.post(url, json=json)

def DELETE(ID):
    return requests.delete(f'{url}/{ID}')

def PUT(ID, json):
    return requests.put(f'{url}/{ID}', json=json)


def main():
    
    entry = None
    
    while True:
        
        print("Por favor, insira um numero de 1 a 6")
        print("1 - GET - Seleciona todas as tarefas")
        print("2 - GET - Seleciona uma tarefa")
        print("3 - POST - Insere uma tarefa")
        print("4 - DELETE - Deleta uma tarefa")
        print("5 - PUT - Altera uma tarefa")
        print("6 - EXIT - Fecha a aplicacao")
        
        try:
            entry = int(input())
        except ValueError:
            print("Insira um numero inteiro por favor")
            continue
        
        if entry == 6:
            break
        
        if entry < 1 and entry > 6:
            print("Insira um numero entre 1 e 6 por favor")
            continue
        
        # REQUEST 1
        if entry == 1:
            req = GET(None)
            print(req.content)
            continue
            
        # REQUEST 2
        if entry == 2:
            print("Insira um ID valido por favor")
            ID = None
            try:
                ID = int(input())
                req = GET(ID)
                print(req.content)
            except ValueError:
                print("Insira um numero inteiro para o ID")
                continue
            except:
                print("Insira um ID existente")
                continue
        
        # REQUEST 3
        if entry == 3:
            print("Insira os valores para uma nova tarefa")
            
            print("Descricao")
            descricao = input()
            
            print("Prazo limite - Data formato ISO (2022-12-15 15:00)")
            prazo = input()
            
            print("Completa - true ou false")
            completa = input()
            if completa == "true": completa = True
            else: completa = False
            
            json = {
                "descricao": descricao,
                "prazo": prazo,
                "completa": completa
            }
            
            req = POST(json)
         
        # REQUEST 4
        if entry == 4:
            print("Insira um ID para deletar")
            ID = None
            try:
                ID = int(input())
                req = DELETE(ID)
            except ValueError:
                print("Insira um numero inteiro para o ID")
                continue
            except:
                print("Insira um ID existente")
                continue
        
        # REQUEST 5
        if entry == 5:
            print("Insira os ID e os valores de uma tarefa para edita-la")
            
            ID = None
            try:
                print("ID")
                ID = int(input())
            except ValueError:
                print("Insira um numero inteiro para o ID")
                continue
            except:
                print("Insira um ID existente")
                continue 
            
            print(ID)
            print("Descricao")
            descricao = input()
            
            print("Prazo limite - Data formato ISO (2022-12-15)")
            prazo = input()
            
            print("Completa - true ou false")
            completa = input()
            if completa == "true": completa = True
            else: completa = False
            
            json = {
                "descricao": descricao,
                "prazo": prazo,
                "completa": completa
            }
            
            req = PUT(ID, json)
            
            
        
main()
        
        
        

