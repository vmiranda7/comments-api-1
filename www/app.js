//'use strict';
//
//// Declare app level module which depends on views, and components
//angular.module('myApp', [
//  'ngRoute',
//  'myApp.view1',
//  'myApp.view2',
//  'myApp.version'
//]).
//config(['$routeProvider', function($routeProvider) {
//  $routeProvider.otherwise({redirectTo: '/view1'});
//}]);

var app = angular.module('seminario', []);

app.controller('UserController', ['$http', function ($http) {
    var seminar = this;
    seminar.users = [];

    $http.get("http://localhost:8010/comments-api/users").success(function (data) {
        seminar.users = data.users.entry;
    }).error(function () {
        seminar.users = data;
    });
}]);

app.controller('FormController', ['$http', function ($http) {
    this.user = {};

    this.addUser = function (seminar) {
        seminar.users.push(this.user);

        $http({
            method: 'POST',
            url: "http://localhost:8010/comments-api/users",
            data: this.user,
            headers: {'Content-Type': 'application/vnd.comments.api.user+json'}
        }).success(function (data) {
            // Do nothing
        }).error(function () {
            window.alert("ERROR");
        });

        this.user = {};
    }
}]);

app.controller('TabController', function () {
    this.tab = 1;

    this.setTab = function (selectedTab) {
        this.tab = selectedTab;
    };

    this.isSet = function (givenTab) {
        return this.tab === givenTab;
    };
});