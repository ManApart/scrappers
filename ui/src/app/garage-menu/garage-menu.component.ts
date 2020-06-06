import { Component, OnInit } from '@angular/core';
import { BotService } from '../botService';

@Component({
  selector: 'app-garage-menu',
  templateUrl: './garage-menu.component.html',
  styleUrls: ['./garage-menu.component.css']
})
export class GarageMenuComponent implements OnInit {

  constructor(private botService: BotService) { }

  bot


  ngOnInit() {
    this.botService.getBot().toPromise().then(result => {
      this.bot = result
      console.log(JSON.stringify(this.bot))
    })
  }

}
