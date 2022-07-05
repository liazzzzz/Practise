import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class MessageService {

  messages: string[] = []; // массив строк пустой

  add(message: string) {  // добавление сообщения в кэш
    this.messages.push(message); // добавляет в массив переданный элемент
  }

  clear() {  // удаление
    this.messages = [];
  }

  constructor() {
  }
}
