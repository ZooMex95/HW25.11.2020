# HW25.11.2020
На входе имеется файл в формате json, содержащий информацию о каком-то количестве организаций, в т.ч. названия, адреса, номера телефонов, ИНН, ОГРН, а также о ценных бумагах, которыми владеет каждая компания.
Необходимо сформировать на основе исходного файла коллекцию объектов без потери информации, где каждый объект представляет одну организацию.
Для сформированной коллекции:
- Вывести все имеющиеся компании в формате «Краткое название» – «Дата основания 17/01/98»;
- Вывести все ценные бумаги (их код, дату истечения и полное название организации-владельца), которые просрочены на текущий день, а также посчитать суммарное число всех таких бумаг;
- На запрос пользователя в виде даты «ДД.ММ.ГГГГ», «ДД.ММ,ГГ», «ДД/ММ/ГГГГ» и «ДД/ММ/ГГ» вывести название и дату создания всех организаций, основанных после введенной даты;
- На запрос пользователя в виде кода валюты, например EU, USD, RUB и пр. выводить id и коды ценных бумаг, использующих заданную валюту.