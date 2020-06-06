import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';

@Injectable()
export class BotService {
  constructor(private http: HttpClient) { }

  getBot() {
    return this.http.get(`http://localhost:8080/bot`, {
      headers: new HttpHeaders({}),
      responseType: 'json'
    })
  }
}