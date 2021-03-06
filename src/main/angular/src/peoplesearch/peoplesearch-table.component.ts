import { Component } from '../component';
import IPeopleService from '../services/people.service';
import { IScope } from 'angular';
import Person from '../models/person.model';
import PeopleSearchBaseComponent from './peoplesearch-base.component';
import {IConfigService} from '../services/config.service';


@Component({
    stylesheetUrl: require('peoplesearch/peoplesearch-table.component.scss'),
    templateUrl: require('peoplesearch/peoplesearch-table.component.html')
})
export default class PeopleSearchTableComponent extends PeopleSearchBaseComponent {
    columnConfiguration: any;

    static $inject = [ '$scope', '$state', '$stateParams', 'ConfigService', 'PeopleService' ];
    constructor($scope: IScope,
                $state: angular.ui.IStateService,
                $stateParams: angular.ui.IStateParamsService,
                private configService: IConfigService,
                peopleService: IPeopleService) {
        super($scope, $state, $stateParams, peopleService);
    }

    $onInit(): void {
        super.$onInit();

        var self = this;

        // The table columns are dynamic and configured via a service
        this.configService.getColumnConfiguration().then((columnConfiguration: any) => {
            self.columnConfiguration = columnConfiguration;
        });

        // Fetch data when query changes
        this.$scope.$watch('$ctrl.query', (newValue: string) => {
            if (!newValue) {
                self.people = [];
            }
            else {
                this.peopleService
                    .search(newValue)
                    .then((people: Person[]) => {
                        self.people = people;
                    });
            }
        });
    }

    gotoCardsView() {
        super.gotoState('search.cards');
    }
}
