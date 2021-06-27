import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { User } from '../../Models/user';
import { UserService } from '../../Services/user.service';

@Component({
  selector: 'app-user-list',
  templateUrl: './user-list.component.html',
  styleUrls: ['./user-list.component.css']
})
export class UserListComponent implements OnInit {

  users: User[];

  constructor(private userService: UserService, private router: Router) { }

  ngOnInit(): void {
    this.getUsers();
  }

  getUsers() {
    this.userService.getUserList().subscribe(data => this.users = data);
  }

  viewUser(id: number) {
    this.router.navigate(['/user-details', id]);
  }
  updateUser(id: number) {
    this.router.navigate(['/update-user', id]);
  }
  deleteUser(id: number) {
    this.userService.deleteUser(id).subscribe(data => {
      console.log(data);
      this.getUsers();
    }
    )
  }
}
